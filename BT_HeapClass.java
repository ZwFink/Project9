package p9_Package;


/**
 * Class uses a node-based max heap data structure to
 * manage priority of characters
 *
 * @author MichaelL with code from Zane Fink
 */
public class BT_HeapClass
{
   public class NodeClass
   {
       char dataValue;

       NodeClass parentRef;
       NodeClass leftChildRef;
       NodeClass rightChildRef;

       private NodeClass( char inData )
       {
           dataValue = inData;

           parentRef = null;
           leftChildRef = null
           rightChildRef = null;

       }
   }

    /**
     * Constant character for space
     */
   private static final char SPACE = ' ';

    /**
     * Constant character for dask
     */
   private static final char DASH = ' ';

    /**
     * Head reference for binary tree
     */
   private NodeClass heapHead;

    /**
     * Boolean value to manage graphical tree display
     */
   private boolean rowStartFlag;

    /**
     * Boolean flag to allow viewing of shifting actions
     */
   private boolean viewShiftFlag;

    /**
     * HeapClass constructor, initializes heapHead and
     * shift view flag
     */
   public BT_HeapClass()
   {
      heapHead = null;
      viewShiftFlag = false;
   }

    /**
     * Adds item to heap at end, then shifts it up to the correct level
     * <p>
     * Note: Handles first node at head, then calls recursive helper
     * @param dataChar character data to be added to the head
     */
   public void addItem( char dataChar )
   {
       NodeClass newNode = new NodeClass( dataChar );
       if( heapHead == null )
       {
           heapHead = newNode;
       }

       else
       {
           int targetLevel = findLeftHeight( heapHead );
           heapHead = addItemHelper( newNode, heapHead.leftChildRef,
                                    targetLevel, 0 );
       }

   }

    /**
     * Recursive helper method to add item to node-based heap
     * @param newItem NodeClass item to be added to the heap
     * @param localRef NodeClass reference to current node level
     * @param targetLevel integer value representing the level under
     *                    which the item should be added
     * @param currentLevel integer value representing the current level
     *                     of the recursive method at a given call
     * @return NodeClass reference returns added node, and
     *          assists with recursion
     */
   private NodeClass addItemHelper( NodeClass newItem, NodeClass localRef,
                                    int targetLevel, int currentLevel )
   {
      if( targetLevel == currentLevel )
      {
          return newItem;
      }

      if( ( currentLevel + 1 ) == targetLevel )
      {
         newItem.parentRef = localRef;
      }

      if( findLeftHeight( localRef ) >
          findRightHeight( localRef )
        )
      {
          localRef.rightChildRef = addItemHelper( newItem, localRef.rightChildRef,
                                targetLevel, currentLevel + 1 );
      }

      else
      {
          localRef.leftChildRef = addItemHelper( newItem, localRef.leftChildRef,
                                                 targetLevel, currentLevel + 1 );
      }
      return localRef;
   }

    /**
     * Removes item from the top of heap
     * <p> Note: Handles empty list and one (head) node, then
     * calls recursive helper
     * @return NodeClass data found at the top
     */
   public NodeClass removeItem()
   {
       // TODO: Implement this
   }
   private void removeLastNode( NodeClass localRef, int targetLevel, int currentLevel )
   {
      // TODO: Implement code for removeLastNode
   }

    /**
     * Recreates heap after data has been added to the
     * end of the heap
     * @param currentNodeRef NodeClass reference at current level
     *                       in recursion; starts at bottom of heap location
     *                       of new item
     */
   private void bubbleUpNodeHeap( NodeClass currentNodeRef )
   {
      // TODO: Implement this method
   }

    /**
     * Recreates heap after data has been removed from the top of the heap
     * and last item has been placed there
     * @param currentNodeRef NodeClass reference at current level in recursion;
     *                       starts at the top of heap - location of
     *                       replacement item
     */
   private void trickleDownNodeHeap( NodeClass currentNodeRef )
   {

   }

    /**
     * Swaps the data between two NodeClass objects
     * @param oneNode NodeClass object having data
     * @param otherNode NodeClass object having data
     */
   private void swapNodeData( NodeClass oneNode, NodeClass otherNode )
   {
      // TODO: Implement this
   }

    /**
     * Allows user to set shift flag to view bubble up or
     * trickle down shifting operations
     * @param shiftFlagSet
     */
   public void setViewFlag( boolean shiftFlagSet )
   {
       viewShiftFlag = shiftFlagSet;
   }

    /**
     * Finds the height of the tree on the left side
     * @param localRoot NodeClass reference at the current recursion level
     * @return integer height of the left side of the tree
     */
   public int findLeftHeight( NodeClass localRoot )
   {
      if( localRoot == null )
      {
          return -1;
      }

      return 1 + findLeftHeight( localRoot.leftChildRef );
   }

    /**
     * Finds the height of the tree on the right side
     * @param localRoot NodeClass reference at the current recursion level
     * @return integer height of the left side of the tree
     */
   public int findRightHeight( NodeClass localRoot )
   {
       if (localRoot == null) {
           return -1;
       }

       return 1 + findRightHeight(localRoot.rightChildRef);
   }

    /**
     * Displays text-graphical representation of oen level/line of the
     * binary tree
     * @param workingNode NodeClass reference at the current recursion level
     * @param nodeHeight integer height of tree plus two for current height
     *                   of nodes, including lowermost null children
     * @param displayLevel integer level of tree at which the current line
     *                     of display is to be presented
     * @param workingLevel integer current level during recursive actions
     */
   private void displayAtTreeLevel( NodeClass workingNode, int nodeHeight,
                                    int displayLevel, int workingLevel )
   {
       char charOut = workingNode.dataValue;

       if( workingLevel == displayLevel )
       {
           displayValue( charOut, nodeHeight, workingLevel );

           return;
       }

       if( workingNode.leftChildRef != null )
       {
          displayAtTreeLevel( workingNode.leftChildRef, nodeHeight,
                              displayLevel, workingLevel + 1 );
       }

       else
       {
           displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
       }

       if( workingNode.rightChildRef != null )
       {
           displayAtTreeLevel( workingNode.rightChildRef, nodeHeight,
                               displayLevel, workingLevel + 1 );
       }

       else
       {
           displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
       }
   }

    /**
     * Test for empty tree
     * @return Boolean result of test
     */
   public boolean isEmpty()
   {
       return heapHead == null;
   }

    /**
     * Local recursive method to display a specified number of a
     * specified character
     * @param numChars integer number of characters to display
     * @param outChar character do display
     */
   private void displayChars( int numChars, char outChar )
   {
      if( numChars > 0 )
      {
          System.out.print( outChar );

          displayChars( numChars - 1, outChar );
      }
   }

    /**
     * Local recursive method to calculate exponentiation
     * with integers
     * @param base base of exponentiation
     * @param exponent exponent of exponentiation
     * @return result of exponentiation calculation
     */
   private int toPower( int base, int exponent )
   {
       if( exponent > 0 )
       {
           return toPower( base, exponent - 1 ) * base;
       }
       return 1;
   }

    /**
     * DIsplays text-graphical representation of Binary Tree
     */
   public void displayTreeStructure()
   {
      int displayLevel, nodeHeight = findLeftHeight( heapHead ) + 2;
      int workingLevel = 1;

      if( heapHead != null )
      {
          for( displayLevel = 1; displayLevel <= nodeHeight; displayLevel++ )
          {
             rowStartFlag = true;

             displayAtTreeLevel( heapHead, nodeHeight,
                                displayLevel, workingLevel );
          }

          System.out.println();
      }

      else
      {
        System.out.println( "\nEmpty Tree - No Display" );
      }

   }

    /**
     * Method used to display a character along with calculated
     * leading spaces
     * <p> Note: Used in displayAtTreeLevel and displayEmptyNodeSpaces
     * @param data data value to display, either letter or color data
     * @param nodeHeight height of nodes, including lowermost null children
     * @param workingLevel current level during recursive actions
     */
   private void displayValue( char data, int nodeHeight, int workingLevel )
   {
      int leadingSpaces;

      if( rowStartFlag )
      {
          leadingSpaces = toPower( 2, nodeHeight - workingLevel );

          rowStartFlag = false;
      }

      else
      {
          leadingSpaces = toPower( 2, nodeHeight - workingLevel + 1 );
      }

      displayChars( leadingSpaces, SPACE );

      System.out.print( data );

   }

    /**
     * Method that displays null or blank nodes
     * for a tree at null locations
     *
     * <p> Note: used by displayAtTreeLevel
     * @param nodeHeight height of tree plus two for
     *                   current height of nodes, including lowermost
     *                   null children
     * @param displayLevel level of the tree at which the display will be applied
     * @param workingLevel level of tree just below non-null node
     *                     at which method is currently working
     */
   private void displayEmptyNodeSpaces( int nodeHeight,
                                        int displayLevel, int workingLevel )
   {
        int nodesToDisplay = toPower( 2, displayLevel - workingLevel );
        char charOut = SPACE;

        if( displayLevel == workingLevel )
        {
            charOut = DASH;
        }

        while( nodesToDisplay > 0 )
        {
            displayValue( charOut, nodeHeight, displayLevel );

            nodesToDisplay--;
        }
   }

    /**
     * Clears heap tree
     */
   public void clearTree()
   {
      heapHead = null;
   }
}

