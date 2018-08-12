package com.itheima.bos.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Entity
@Table(name = "bc_staff", schema = "bos32", catalog = "")
public class Staff {
    private String id;
    private String name;
    private String telephone;
    private String haspda;
    private String deltag;
    private String station;
    private String standard;
    private Collection<Decidedzone> bcDecidedzonesById;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "haspda", nullable = true, length = 1)
    public String getHaspda() {
        return haspda;
    }

    public void setHaspda(String haspda) {
        this.haspda = haspda;
    }

    @Basic
    @Column(name = "deltag", nullable = true, length = 1)
    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    @Basic
    @Column(name = "station", nullable = true, length = 40)
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Basic
    @Column(name = "standard", nullable = true, length = 100)
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != null ? !id.equals(staff.id) : staff.id != null) return false;
        if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
        if (telephone != null ? !telephone.equals(staff.telephone) : staff.telephone != null) return false;
        if (haspda != null ? !haspda.equals(staff.haspda) : staff.haspda != null) return false;
        if (deltag != null ? !deltag.equals(staff.deltag) : staff.deltag != null) return false;
        if (station != null ? !station.equals(staff.station) : staff.station != null) return false;
        if (standard != null ? !standard.equals(staff.standard) : staff.standard != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (haspda != null ? haspda.hashCode() : 0);
        result = 31 * result + (deltag != null ? deltag.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        result = 31 * result + (standard != null ? standard.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bcStaffByStaffId")
    public Collection <Decidedzone> getBcDecidedzonesById() {
        return bcDecidedzonesById;
    }

    public void setBcDecidedzonesById(Collection <Decidedzone> bcDecidedzonesById) {
        this.bcDecidedzonesById = bcDecidedzonesById;
    }
}