package entities;

import adt.tad.ArrayListOb;
import adt.tad.LinkedListOb;
import adt.tad.ListOb;
import adt.tad.SimpleNode;

public class Brewery {
    private long id;
    private String name;
    private ListOb<Beer> beers;

    public Brewery(long idNum, String brName){
        this.id = idNum;
        this.name = brName;
        this.beers = new ArrayListOb<Beer>(Beer.class);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
