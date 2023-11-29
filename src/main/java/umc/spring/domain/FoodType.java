package umc.spring.domain;

import lombok.*;
import umc.spring.domain.mapping.FoodTypeStore;
import umc.spring.domain.mapping.FoodTypeUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodTypeStore> foodTypeStores = new ArrayList<>();
    @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<FoodTypeUser> foodTypeUsers = new ArrayList<>();
}
