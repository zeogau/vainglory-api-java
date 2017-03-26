package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.datadumper.service.EntityManagement;

import javax.persistence.*;


/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Hero.findAll",
                query="SELECT x FROM Hero x"),
        @NamedQuery(name="Hero.findByName",
                query="SELECT x FROM Hero x WHERE x.heroName = :name"),
        @NamedQuery(name="Hero.findByAlias",
                query="SELECT x FROM Hero x WHERE x.aliasName = :name"),
})
@Entity
@Table(name="Hero", schema = "rawdata")
public class Hero  {
    public final static String FINDALL = "Hero.findAll";
    public final static String FINDBYNAME = "Hero.findByName";
    public final static String FINDBYNAME_PARAM = "name";
    public final static String FINDBYALIAS = "Hero.findByAlias";
    public final static String FINDBYALIAS_PARAM = "name";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Short heroId;

    @Column
    private String heroName;

    @Column
    private String aliasName;


    public static void main(String[] args) {
        EntityManager em = EntityManagement.getTheManager();
        Hero h = new Hero("Cath");
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();;
    }



    public Hero() {}

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (!heroId.equals(hero.heroId)) return false;
        return heroName.equals(hero.heroName);
    }

    @Override
    public int hashCode() {
        int result = heroId.hashCode();
        result = 31 * result + heroName.hashCode();
        return result;
    }

    public Short getHeroId() {
        return heroId;
    }

    public void setHeroId(Short heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

}
