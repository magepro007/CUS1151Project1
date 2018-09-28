package com.Hershil;


import java.util.Queue;
import java.util.Stack;

import java.util.LinkedList;

public class Part2
{

    /**
     * Copies a stack of integers while preserving the original stack.
     * @param originalStack stack of integers to be copied.
     * @return copyStack stack of integers that is a copy of originalStack.
     */
    public Stack<Integer> copyStack(Stack<Integer> originalStack)
    {
        Stack<Integer> copyStack = new Stack<>();
        Queue<Integer> auxQueue = new LinkedList<>();


        //Adds values from originalStack to auxQueue
        while (!originalStack.empty())
        {
            auxQueue.add(originalStack.pop());
        }

        //Adds values from auxQueue to originalStack.
        while (!auxQueue.isEmpty())
        {
            originalStack.push(auxQueue.remove());
        }
        //These values are now in reverse order.


        //Adds values from originalStack to auxQueue.
        while (!originalStack.empty())
        {
            auxQueue.add(originalStack.pop());
        }

        //Adds values from auxQueue to originalStack and copyStack.
        while (!auxQueue.isEmpty())
        {
            int x = auxQueue.remove();
            originalStack.push(x);
            copyStack.push(x);
        }
        //These values are now in the correct order.


        return copyStack;
    }

    /**
     * Takes two stacks of integers and determines if they are equal in terms of values
     * and order of those values.
     * @param stackA a stack of integers to be compared with.
     * @param stackB a stack of integers to be compared with.
     * @return boolean result.  True if stackA and stackB are equal, false otherwise.
     */
    public boolean equals(Stack<Integer> stackA, Stack<Integer> stackB)
    {
        Stack<Integer> auxStack = new Stack<>();

        //If the stacks are not the same size, they cannot be equal.
        if (stackA.size() != stackB.size())
        {
            return false;
        }
        //If they are both empty, they are equal.
        else if (stackA.empty() && stackB.empty())
        {
            return true;
        }

        boolean result = true;

        //Compares each value in both stacks.
        while(!stackA.empty() && !stackB.empty())
        {
            int x = stackA.pop();
            int y = stackB.pop();

            //If they match, they are added to auxStack
            if (x == y)
            {
                auxStack.push(y);
                auxStack.push(x);
            }
            /*
            If one of them do not match, result is set to false, but the values are still added to auxStack
            so that they may be returned to their original stacks in their original order.
             */
            else
            {
               result = false;
               auxStack.push(y);
               auxStack.push(x);
            }
        }

        //Values are returned back to their respective stacks.
        while(!auxStack.empty())
        {
            stackA.push(auxStack.pop());
            stackB.push(auxStack.pop());
        }

        return result;

    }

    /**
     * Rearranges a queue of integers where the even numbers are in the front and the odd numbers are
     * in the back.  The number's order is preserved.
     * @param queueA a queue of integers to be rearranged
     */
    public void rearreange(Queue<Integer> queueA)
    {
        Stack<Integer> auxStack = new Stack<>();

        //Cycles through values in queueA and adding odd values into auxStack.
        int size = queueA.size();
        for(int i = 0; i < size; i++)
        {
            if ((queueA.element() % 2) != 0)
            {
                auxStack.push(queueA.remove());
            }
            else
            {
                queueA.add(queueA.remove());
            }
        }


        //Adds values from auxStack back into queueA
        while(!auxStack.empty())
        {
            queueA.add(auxStack.pop());
        }

        /*
        At this point, the even values are in the front of the queue and the odds are in the back, but, the odd numbers
        are in the reverse order.  So we have to put those values back into auxStack and then pass them back into the
        queueA in order to get them in the correct order.
         */

        //Cycles through values in queueA and adding odd values into auxStack
        for(int i = 0; i < size; i++)
        {
            if ((queueA.element() % 2) != 0)
            {
                auxStack.push(queueA.remove());
            }
            else
            {
                queueA.add(queueA.remove());
            }
        }

        //Adds values from stack back into queue
        while(!auxStack.empty())
        {
            queueA.add(auxStack.pop());
        }

    }


    /**
     * Determines whether a queue is a palindrome.
     * @param queueA a queue of integers.
     * @return boolean result.  True if the queue is a palindrome, false otherwise.
     */
    public boolean isPalindrome(Queue<Integer> queueA)
    {
        Stack<Integer> auxStack =  new Stack<>();

        //Puts elements into auxStack without removing them from queueA so that it creates a reverse copy of it.
        for(int i = 0; i < queueA.size(); i++)
        {
            auxStack.push(queueA.peek());
            queueA.add(queueA.remove());
        }

        /*
        Compares each value in queueA and auxStack.  Since auxStack is the revers of queueA, comparing the top value
        from each DS will suffice in checking to see if it is a palindrome.
         */

        boolean same = true;
        while(!auxStack.empty())
        {
            int x = auxStack.pop();
            int y = queueA.element();

            /*
            If one of them does not match, the result is false, but the elements are still returned
            to their original order.
             */
            if (x != y)
            {
                same = false;
            }

            queueA.add(queueA.remove());
        }

        return same;


    }

    /**
     * Shifts a stack of integers given a position n.
     * The numbers from that position are moved to the front.
     * @param stackA stack of integers to be shifted.
     * @param n integer marks where the shift should start.
     */
    public void shift(Stack<Integer> stackA, int n)
    {
        Queue<Integer> auxQueue = new LinkedList<>();

        //Adds values from stackA to auxQueue
        while(!stackA.empty())
        {
            auxQueue.add(stackA.pop());
        }

        //Adds values from auxQueue to stackA
        while(!auxQueue.isEmpty())
        {
            stackA.push(auxQueue.remove());
        }

        //Adds values from stackA to auxQueue to be manipulated (values are reversed now)
        while(!stackA.empty())
        {
            auxQueue.add(stackA.pop());
        }

        //Takes all the values up to n and adds them to stackA
        for (int i = 0; i < n; i++)
        {
            stackA.push(auxQueue.remove());
        }

        //Adds values from stackA (the values to be shifted) to auxQueue.
        while(!stackA.empty())
        {
            auxQueue.add(stackA.pop());
        }

        /*
        Adds values from auxQueue to stackA.  Values will then be in the original DS and will be in the
        correct order, albeit shifted.
         */
        while(!auxQueue.isEmpty())
        {
            stackA.push(auxQueue.remove());
        }
    }

    public static void main(String[] args)
    {
        Part2 test = new Part2();

        System.out.println("Question 5: copyStack");
        System.out.println();

        System.out.println("Test case: normal stack");
        System.out.println();

        Stack<Integer> EMPTY_STACK = new Stack<>();
        Queue<Integer> EMPTY_QUEUE = new LinkedList<>();

        Stack<Integer> stack1 = new Stack<>();
        stack1.add(1);
        stack1.add(2);
        stack1.add(3);
        stack1.add(4);
        stack1.add(5);

        System.out.println("Original: " + stack1);
        System.out.println("Copy: " + test.copyStack(stack1));
        System.out.println("Original after method: " + stack1);

        System.out.println();
        System.out.println("Test case: empty");
        System.out.println();


        System.out.println("Original: " + EMPTY_STACK);
        System.out.println("Copy: " + test.copyStack(EMPTY_STACK));
        System.out.println("Original after method: " + EMPTY_STACK);

        System.out.println("_____________________________________________________________________");
        System.out.println();
        System.out.println("Question 6: equals");
        System.out.println();

        System.out.println("Test case: equal stacks");
        System.out.println();

        Stack<Integer> stack2 = new Stack<>();
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.add(4);
        stack2.add(5);
        Stack<Integer> stack3 = new Stack<>();
        stack3.add(1);
        stack3.add(2);
        stack3.add(3);
        stack3.add(4);
        stack3.add(5);

        System.out.println("Originals: " + stack2 + " :: " + stack3);
        System.out.println("Equal? " + test.equals(stack2, stack3));
        System.out.println("Originals after method: " + stack2 + " :: " + stack3);

        System.out.println();
        System.out.println("Test case: unequal stacks");
        System.out.println();

        Stack<Integer> stack21 = new Stack<>();
        stack21.add(1);
        stack21.add(7);
        stack21.add(3);
        stack21.add(4);
        stack21.add(5);
        Stack<Integer> stack31 = new Stack<>();
        stack31.add(1);
        stack31.add(2);
        stack31.add(3);
        stack31.add(4);
        stack31.add(5);

        System.out.println("Originals: " + stack21 + " :: " + stack31);
        System.out.println("Equal? " + test.equals(stack21, stack31));
        System.out.println("Originals after method: " + stack21 + " :: " + stack31);

        System.out.println();
        System.out.println("Test case: empty stacks");
        System.out.println();

        System.out.println("Originals: " + EMPTY_STACK + " :: " + EMPTY_STACK);
        System.out.println("Equal? " + test.equals(EMPTY_STACK, EMPTY_STACK));
        System.out.println("Originals after method: " + EMPTY_STACK + " :: " + EMPTY_STACK);

        System.out.println();
        System.out.println("Test case: empty stack and non-empty stack");
        System.out.println();

        System.out.println("Originals: " + EMPTY_STACK + " :: " + stack2);
        System.out.println("Equal? " + test.equals(EMPTY_STACK, stack2));
        System.out.println("Originals after method: " + EMPTY_STACK + " :: " + stack2);

        System.out.println("_____________________________________________________________________");
        System.out.println();
        System.out.println("Question 7: rearrange");
        System.out.println();

        System.out.println("Test case: Example case (see project 1 pdf)");
        System.out.println();

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(3);
        queue2.add(5);
        queue2.add(4);
        queue2.add(17);
        queue2.add(6);
        queue2.add(83);
        queue2.add(1);
        queue2.add(84);
        queue2.add(16);
        queue2.add(37);
        System.out.println("Original: " + queue2);
        test.rearreange(queue2);
        System.out.println("Rearranged: " + queue2);

        System.out.println();
        System.out.println("Test case: empty queue");
        System.out.println();

        System.out.println("Original: " + EMPTY_QUEUE);
        test.rearreange(EMPTY_QUEUE);
        System.out.println("Rearranged: " + EMPTY_QUEUE);

        System.out.println();
        System.out.println("Test case: No odds");
        System.out.println();

        Queue<Integer> queue21 = new LinkedList<>();
        queue21.add(2);
        queue21.add(6);
        queue21.add(4);
        queue21.add(16);
        queue21.add(6);
        queue21.add(82);
        queue21.add(8);
        queue21.add(84);
        queue21.add(16);
        queue21.add(30);

        System.out.println("Original: " + queue21);
        test.rearreange(queue21);
        System.out.println("Rearranged: " + queue21);

        System.out.println("_____________________________________________________________________");
        System.out.println();
        System.out.println("Question 8: isPalindrome");
        System.out.println();

        System.out.println("Test case: Example case (see project 1 pdf)");
        System.out.println();

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(3);
        queue1.add(8);
        queue1.add(17);
        queue1.add(9);
        queue1.add(17);
        queue1.add(8);
        queue1.add(3);
        System.out.println("Original: " + queue1);
        System.out.println("Palindrome? " + test.isPalindrome(queue1));
        System.out.println("Original after method: " + queue1);

        System.out.println();
        System.out.println("Test case: not palindrome");
        System.out.println();

        Queue<Integer> queue11 = new LinkedList<>();
        queue11.add(2);
        queue11.add(8);
        queue11.add(143);
        queue11.add(9);
        queue11.add(172);
        queue11.add(8);
        queue11.add(3);

        System.out.println("Original: " + queue11);
        System.out.println("Palindrome? " + test.isPalindrome(queue11));
        System.out.println("Original after method: " + queue11);

        System.out.println();
        System.out.println("Test case: empty queue");
        System.out.println();

        System.out.println("Original: " + EMPTY_QUEUE);
        System.out.println("Palindrome? " + test.isPalindrome(EMPTY_QUEUE));
        System.out.println("Original after method: " + EMPTY_QUEUE);


        System.out.println("_____________________________________________________________________");
        System.out.println();
        System.out.println("Question 9: shift");
        System.out.println();

        System.out.println("Test case: Example case (see project 1 pdf)");
        System.out.println();

        Stack<Integer> stack4 = new Stack<>();
        stack4.add(1);
        stack4.add(2);
        stack4.add(3);
        stack4.add(4);
        stack4.add(5);
        stack4.add(6);
        stack4.add(7);
        stack4.add(8);
        stack4.add(9);
        stack4.add(10);

        System.out.println("Original: " + stack4);
        test.shift(stack4, 6);
        System.out.println("Shift: " + stack4);

        System.out.println();
        System.out.println("Test case: Example case (see project 1 pdf)");
        System.out.println();

        Stack<Integer> stack41 = new Stack<>();
        stack41.add(7);
        stack41.add(23);
        stack41.add(-7);
        stack41.add(0);
        stack41.add(22);
        stack41.add(-8);
        stack41.add(4);
        stack41.add(5);

        System.out.println("Original: " + stack41);
        test.shift(stack41, 3);
        System.out.println("Shift: " + stack41);

        System.out.println();
        System.out.println("Test case: empty stack");
        System.out.println();

        System.out.println("Original: " + EMPTY_STACK);
        test.shift(EMPTY_STACK, 0);
        System.out.println("Shift: " + EMPTY_STACK);

        System.out.println();
        System.out.println("Test case: Shift all of the numbers");
        System.out.println();

        Stack<Integer> stack42 = new Stack<>();
        stack42.add(1);
        stack42.add(2);
        stack42.add(3);
        stack42.add(4);
        stack42.add(5);
        stack42.add(6);
        stack42.add(7);
        stack42.add(8);
        stack42.add(9);
        stack42.add(10);
        System.out.println("Original: " + stack42);
        test.shift(stack42, 10);
        System.out.println("Shift: " + stack42);





    }

}


