package com.gabrego.citasapi.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "clinic_schedule")
public class ClinicSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    private Clinic clinic_id;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "finish_time")
    private Time finish_time;

    @Column(name = "receso_inicio")
    private Time receso_inicio;

    @Column(name = "receso_fin")
    private Time receso_fin;

    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Day day_id;

    public ClinicSchedule() {
    }

    public ClinicSchedule(int id, Clinic clinic_id, Time start_time, Time finish_time, Time receso_inicio, Time receso_fin, Day day_id) {
        this.id = id;
        this.clinic_id = clinic_id;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.receso_inicio = receso_inicio;
        this.receso_fin = receso_fin;
        this.day_id = day_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clinic getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(Clinic clinic_id) {
        this.clinic_id = clinic_id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Time finish_time) {
        this.finish_time = finish_time;
    }

    public Time getReceso_inicio() {
        return receso_inicio;
    }

    public void setReceso_inicio(Time receso_inicio) {
        this.receso_inicio = receso_inicio;
    }

    public Time getReceso_fin() {
        return receso_fin;
    }

    public void setReceso_fin(Time receso_fin) {
        this.receso_fin = receso_fin;
    }

    public Day getDay_id() {
        return day_id;
    }

    public void setDay_id(Day day_id) {
        this.day_id = day_id;
    }

    @Override
    public String toString() {
        return "ClinicSchedule{" +
                "id=" + id +
                ", clinic_id=" + clinic_id +
                ", start_time=" + start_time +
                ", finish_time=" + finish_time +
                ", receso_inicio=" + receso_inicio +
                ", receso_fin=" + receso_fin +
                ", day_id=" + day_id +
                '}';
    }
}
