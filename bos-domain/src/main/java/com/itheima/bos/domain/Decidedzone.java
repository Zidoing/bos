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
@Table(name = "bc_decidedzone", schema = "bos32", catalog = "")
public class Decidedzone {
    private String id;
    private String name;
    private Staff bcStaffByStaffId;
    private Collection<Subarea> bcSubareasById;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Decidedzone that = (Decidedzone) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    public Staff getBcStaffByStaffId() {
        return bcStaffByStaffId;
    }

    public void setBcStaffByStaffId(Staff bcStaffByStaffId) {
        this.bcStaffByStaffId = bcStaffByStaffId;
    }

    @OneToMany(mappedBy = "bcDecidedzoneByDecidedzoneId")
    public Collection <Subarea> getBcSubareasById() {
        return bcSubareasById;
    }

    public void setBcSubareasById(Collection <Subarea> bcSubareasById) {
        this.bcSubareasById = bcSubareasById;
    }
}