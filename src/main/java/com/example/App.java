package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
/** 
 * @author Khoroshko Ekaterina ZKI21-16B 08.05.2024 
 * <h3>Вариант 12 - Ювелирное изделие</h3>
 * 
 * <h2> Spring MVC</h2>
 *
 * <p>Цель работы: ознакомиться c шаблоном MVC в Spring и тем, как он используется при создании web-приложений..</p>
 * 
 * <h4>Общая постановка задачи. </h4>
 *
 * <p> Изменить практическую работу №4 таким образом, чтобы она представляла собой web-приложение. </p>
 * <p>Web-приложение должно иметь следующие страницы:</p>
 *	<ol>
 * <li>  Главная страница содержит приветствие и ссылки на другие, которые дублируют по функционалу пункты меню из работы №4.</li>
 * <li>  Страница просмотра таблицы записей.
 * <li>  Страница добавления новой записи в таблицу.</li>
 * <li>  Страница редактирования записи.</li>
 * <li>  Страница удаления записи.</li>
 * <li>  Страница просмотра записей согласно некоторому критерию (аналогично пункту из практической работы №4).</li>
 *</ol>
 *
 *<p>Помимо этого должны быть осуществлены проверки (не менее двух) входных данных, сопровождающиеся соответствующими диагностическими сообщениями.</p>
 */

@SpringBootApplication
public class App {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        
        SpringApplication.run(App.class, args);
        
    }
    public void prepareDb(){
    	jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS jewel (id SERIAL PRIMARY KEY, size INT, price INT, type VARCHAR(255),metal VARCHAR(255), stone VARCHAR(255));");
    }
    public void run(String... args) throws Exception {
        prepareDb();
    }

}