package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class ListHai {
    private ArrayList<Hai> list=new ArrayList<>();
}
