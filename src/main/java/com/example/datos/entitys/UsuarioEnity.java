package com.example.datos.entitys;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEnity {

    public UsuarioEnity() {
    }

    public UsuarioEnity(Integer id, Integer distance, Integer leftButton, Integer rightButton, Integer doubleClicks, Integer keystrokes, Integer middelButton, Integer mousewheelScrolls, String alias, String fecha) {
        this.id = id;
        this.distance = distance;
        this.leftButton = leftButton;
        this.rightButton = rightButton;
        this.doubleClicks = doubleClicks;
        this.keystrokes = keystrokes;
        this.middelButton = middelButton;
        this.mousewheelScrolls = mousewheelScrolls;
        this.alias = alias;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="distance")
    private Integer distance;

    @Column(name = "left_button")
    private Integer leftButton;

    @Column(name = "right_button")
    private Integer rightButton;

    @Column(name = "double_clicks")
    private Integer doubleClicks;

    @Column(name = "keystrokes")
    private Integer keystrokes;

    @Column(name = "middle_button")
    private Integer middelButton;

    @Column(name = "mousewheel_scrolls")
    private Integer mousewheelScrolls;

    @Column(name = "alias")
    private String alias;

    @Column(name = "fecha")
    private String fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getLeftButton() {
        return leftButton;
    }

    public void setLeftButton(Integer leftButton) {
        this.leftButton = leftButton;
    }

    public Integer getRightButton() {
        return rightButton;
    }

    public void setRightButton(Integer rightButton) {
        this.rightButton = rightButton;
    }

    public Integer getDoubleClicks() {
        return doubleClicks;
    }

    public void setDoubleClicks(Integer doubleClicks) {
        this.doubleClicks = doubleClicks;
    }

    public Integer getKeystrokes() {
        return keystrokes;
    }

    public void setKeystrokes(Integer keystrokes) {
        this.keystrokes = keystrokes;
    }

    public Integer getMiddelButton() {
        return middelButton;
    }

    public void setMiddelButton(Integer middelButton) {
        this.middelButton = middelButton;
    }

    public Integer getMousewheelScrolls() {
        return mousewheelScrolls;
    }

    public void setMousewheelScrolls(Integer mousewheelScrolls) {
        this.mousewheelScrolls = mousewheelScrolls;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
