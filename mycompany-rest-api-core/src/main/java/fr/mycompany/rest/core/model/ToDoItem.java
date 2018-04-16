package fr.mycompany.rest.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shankar Pednekar 25th March 2018
 */
@Entity
public class ToDoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ToDoItem")
    @SequenceGenerator(sequenceName = "S_ToDoItem", allocationSize = 1, name = "S_ToDoItem")
    Long id;
    
	@Column(nullable = false)
    String text;
    @Column(nullable = false)
    Boolean isCompleted;

    @Column(nullable = false)
    String createdAt;

    public ToDoItem() {
    }
    
    public ToDoItem(String text, Boolean isCompleted, String createdAt) {
        this.text = text;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
    
    
    }
