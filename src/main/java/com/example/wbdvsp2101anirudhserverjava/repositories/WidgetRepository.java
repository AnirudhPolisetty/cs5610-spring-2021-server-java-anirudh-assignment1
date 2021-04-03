package com.example.wbdvsp2101anirudhserverjava.repositories;

import com.example.wbdvsp2101anirudhserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    List<Widget> findAllByTopicId(@Param("tid") String topicId);

    @Query(value = "SELECT * FROM widgets", nativeQuery = true)
    List<Widget> findAllWidgets();
}
