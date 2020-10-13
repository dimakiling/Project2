
import java.util.ArrayList;

public class TwoSum 
{
    class Item
    {
        private int value;
        private int index;
        
        public Item(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
        
        public int getValue()
        {
            return value;
        }
        
        public int getIndex()
        {
            return index;
        }
    }
    
    public ArrayList<Item> find(int[] values, int sum)
    {
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i < values.length; i++)
            items.add(new Item(values[i], i));
        
        items = quicksort(items);
        ArrayList<Integer> diffs = computeDiffs(items, sum);
        
        Item item1 = null;
        Item item2 = null;
        
        boolean found = false;
        
        for(int i = 0; i < diffs.get(i) && !found; i++)
        {
            item1 = items.get(i);
            item2 = searchSortedItems(items, diffs.get(i), 0, items.size());
            found = item2 != null;
        }
        
        if(found)
        {
            ArrayList<Item> result = new ArrayList<Item>();
            result.add(item1);
            result.add(item2);
            return result;
        }
        else
            return null;
    }
    
    private Item searchSortedItems(ArrayList<Item> items, Integer value, int lower, int upper)
    {
        if(lower > upper)
            return null;
        int middle = (lower + upper)/2;
        Item middleItem = items.get(middle);
        if(middleItem.getValue() == value)
            return middleItem;
        else if(middleItem.getValue() < value)
            return searchSortedItems(items, value, middle+1, upper);
        else
            return searchSortedItems(items, value, lower, middle-1);
    }
    
    private ArrayList<Integer> computeDiffs(ArrayList<Item> items, int sum)
    {
        ArrayList<Integer> diffs = new ArrayList<Integer>();
        for(int i = 0; i < items.size(); i++)
            diffs.add(sum - items.get(i).getValue());
        return diffs;
    }
    
    private ArrayList<Item> quicksort(ArrayList<Item> items)
    {
        if (items.size() <= 1)
            return items;
        int pivot = items.size() / 2;
        ArrayList<Item> lesser = new ArrayList<Item>();
        ArrayList<Item> greater = new ArrayList<Item>();
        int sameAsPivot = 0;
        for (Item item : items)
        {
            if (item.getValue() > items.get(pivot).getValue())
                greater.add(item);
            else if (item.getValue() < items.get(pivot).getValue())
                lesser.add(item);
            else
                sameAsPivot++;
        }
        
        lesser = quicksort(lesser);
        for (int i = 0; i < sameAsPivot; i++)
            lesser.add(items.get(pivot));
        greater = quicksort(greater);
        ArrayList<Item> sorted = new ArrayList<Item>();
        for (Item item : lesser)
            sorted.add(item);
        for (Item item : greater)
            sorted.add(item);
        return sorted;
    }
    
    public static void main(String[] args)
    {
        int[] s = {-100, -97, -91, -87, -86, -85, -82, -78, -75, -73, -72, -70, -68, -67, -66, -65, -60, -58, -56, -55, -54, -53, -51, -50, -48, -46, -42, -40, -35, -32, -31, -28, -26, -25, -23, -22, -19, -17, -12, -10, -8, -7, -4, -2, 1, 2, 3, 4, 6, 7, 9, 10, 11, 12, 13, 15, 17, 19, 20, 21, 22, 23, 24, 26, 27, 28, 29, 30, 38, 39, 42, 45, 48, 52, 53, 55, 57, 59, 60, 63, 66, 67, 68, 69, 70, 72, 75, 80, 81, 82, 85, 88, 89, 93, 94, 95, 96, 97, 99, 100};
        int value = -85;
        
        TwoSum finder = new TwoSum();
        ArrayList<Item> numbers = finder.find(s, value);
        
        if(numbers != null)
        {
            System.out.println("First Number Found = " + numbers.get(0).getValue() + " ; Index = " + + numbers.get(0).getIndex());
            System.out.println("Second Number Found = " + numbers.get(1).getValue() + " ; Index = " + + numbers.get(1).getIndex());
            
        }
        else 
        {
            System.out.println("No such two numbers found in the array!");
        }
        
    }
}
