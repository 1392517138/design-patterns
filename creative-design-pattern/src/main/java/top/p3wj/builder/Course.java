package top.p3wj.builder;

import lombok.Data;

/**
 * @author Aaron
 * @description
 * @date 2020/10/4 9:35 上午
 */
@Data
public class Course {
    private String name;
    private String ppt;
    private String note;

    public static class Builder {
        private Course course = new Course();

        public Builder addName(String name) {
            course.setName(name);
            return this;
        }

        public Builder addPpt(String name) {
            course.setPpt(name);
            return this;
        }

        public Builder addNote(String name) {
            course.setName(name);
            return this;
        }

        public Course builder() {
            return course;
        }
    }
}
