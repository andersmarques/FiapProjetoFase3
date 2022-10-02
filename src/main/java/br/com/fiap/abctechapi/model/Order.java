package br.com.fiap.abctechapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "oeprator_id", nullable = false)
    private Long operatorId;

    @ManyToMany
    private List<Assistance> assists;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "start_order_location", foreignKey = @ForeignKey(name = "FK_start_order_id"))
    private OrderLocation startOrderLocation;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "end_order_location", foreignKey = @ForeignKey(name = "FK_end_order_id"))
    private OrderLocation endOrderLocation;

    public boolean hasMinAssists() { return assists.size() > 0; }

    public boolean exceedsMaxAssists() { return assists.size() > 15; }
}
