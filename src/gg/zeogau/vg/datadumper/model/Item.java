package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.datadumper.service.EntityManagement;

import javax.persistence.*;

/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Item.findAll",
                query="SELECT x FROM Item x"),
        @NamedQuery(name="Item.findByName",
                query="SELECT x FROM Item x WHERE x.itemName = :name"),
})
@Entity
@Table(name = "Item", schema = "rawdata")
public class Item {
    public final static String FINDALL = "Item.findAll";
    public final static String FINDBYNAME = "Item.findByName";
    public final static String FINDBYNAME_PARAM = "name";




    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer itemId;

    @Column
    private String itemName;

    public static void main(String[] args) {
        EntityManager em = EntityManagement.getTheManager();
        Item h = new Item("Ringo");
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();;

    }


    public Item(){}
    public Item(final String name) {
        this.itemName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!itemId.equals(item.itemId)) return false;
        return itemName.equals(item.itemName);
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + itemName.hashCode();
        return result;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
