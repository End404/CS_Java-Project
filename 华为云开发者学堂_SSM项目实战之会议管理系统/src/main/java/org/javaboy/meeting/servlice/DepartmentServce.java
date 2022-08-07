
//    2.2
//  4.1

package org.javaboy.meeting.servlice;

        import org.javaboy.meeting.mapper.DepartmentMapper;
        import org.javaboy.meeting.model.Department;
        import org.springframework.beans.factory.annotation.Autowired;

        import java.util.List;

public class DepartmentServce {
    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDepById(Integer id) {
        return departmentMapper.getDepById(id);
    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public Integer adddepartment(String departmentname) {
        Department dep = departmentMapper.getDepByName(departmentname);
        if (dep!=null) {
            return -1;
        }
        return departmentMapper.adddepartment(departmentname);
    }

    public Integer deletedep(Integer departmentid) {
        return departmentMapper.deletedep(departmentid);
    }

    public Integer updatedep(Integer id, String name) {
        return departmentMapper.updatedep(id, name);

    }
}
