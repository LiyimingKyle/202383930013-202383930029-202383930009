package com.nuist.test.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
public class ItemTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerTable player;

    @ManyToMany
    @JoinTable(
            name = "item_world",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "world_id")
    )
    private Set<WorldTable> worlds = new HashSet<>();

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlayerTable getPlayer() {
        return player;
    }

    public void setPlayer(PlayerTable player) {
        this.player = player;
    }

    public Set<WorldTable> getWorlds() {
        return worlds;
    }

    public void setWorlds(Set<WorldTable> worlds) {
        this.worlds = worlds;
    }
}
