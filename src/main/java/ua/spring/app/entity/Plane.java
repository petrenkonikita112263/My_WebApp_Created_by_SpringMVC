package ua.spring.app.entity;

import java.util.Objects;

public class Plane {

    private int planeId;
    private String planeName;
    private String planeType;

    public Plane() {
    }

    public Plane(int planeId, String planeName, String planeType) {
        this.planeId = planeId;
        this.planeName = planeName;
        this.planeType = planeType;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                ", planeName='" + planeName + '\'' +
                ", planeType='" + planeType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            Plane plane = (Plane) o;
            return planeId == plane.planeId
                    && Objects.equals(planeName, plane.planeName)
                    && Objects.equals(planeType, plane.planeType);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(planeId, planeName, planeType);
        return (27 + result * 3) / 4;
    }
}
