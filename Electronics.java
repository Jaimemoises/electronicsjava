package CA1;

public class Electronics {

    // Class members | Instance variables -- Properties | Attributes
    private String itemName; // To store the item name
    private String maker; //To store the maker of an item
    private int itemPrice; // To Store the item price

    public Electronics(String itemName, int itemPrice, String maker){
        this.itemName = itemName;
        this.maker = maker;
        this.itemPrice = itemPrice;
    }

    public void displayState(){
        System.out.println("Item name: " + itemName);
        System.out.println("Item price: " + itemPrice);
        System.out.println("Maker: " + maker);
    }

    //getters and setters
    public String getItemName(){
        return itemName;
    }

    public int getItemPrice(){
        return itemPrice;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice){
        this.itemPrice = itemPrice;
    }

    public void setItemMaker(String Maker){
        this.maker = maker;
    }

}//main
