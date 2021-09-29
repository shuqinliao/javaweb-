package basic;

public class Product {
    public static final int PATH_SIZE = 5;//定义分页中的每页记录数，表示一页显示5条数据
    private int id;
    private String name;
    private double price;
    private int num;
    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


}
