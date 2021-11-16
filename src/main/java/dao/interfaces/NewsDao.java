package dao.interfaces;

import models.Department_News;
import models.News;

import java.util.List;

public interface NewsDao {

    //Create
    void addNews(News news);
    void addDepartmentNews(Department_News department_news);

    //Read
    List<News> getAll();
    News findById(int id);

    //Update

    //Delete
    void clearAll();
}
