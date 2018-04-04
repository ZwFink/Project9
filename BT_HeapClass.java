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


}
