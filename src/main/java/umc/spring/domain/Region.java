package umc.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "region",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "region", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Store> stores = new ArrayList<>();
}
