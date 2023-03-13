package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hai {
    private int id;
    private String name;
    private int price;
    public Hai(String name,int price){
        this.name=name;
        this.price=price;
    }
}
