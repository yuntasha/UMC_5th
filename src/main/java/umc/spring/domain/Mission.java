package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserMission;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long dest;
    private Long point;
    private LocalDateTime finish_at;
    @OneToMany(mappedBy = "mission",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MissionImg> missionImg = new ArrayList<>();
    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<UserMission> userMissions = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "store_id")
    private Store store;
}
