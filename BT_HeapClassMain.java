package p9_Package;

public class BT_HeapClassMain
{
    public static void main( String[] args )
    {
        BT_HeapClass heap = new BT_HeapClass();

        heap.addItem( 'c' );
        heap.addItem( 'd' );
        heap.addItem( 'a' );
        heap.addItem( 'f' );
        heap.addItem( 'g' );
        heap.addItem( 'm' );
        heap.addItem( 'l' );
        heap.addItem( 'n' );

        heap.displayTreeStructure();
    }
}
