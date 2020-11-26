package com.want.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Article extends BaseEntity implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "标题不能为空")
	private String title;

	@Column(nullable = false)
	private String body;

	/**
	 * Description: 枚举类型
	 */
	@Column(columnDefinition = "enum('图','图文','文')")
	private String type;// 类型

	/**
	 * Description: Boolean类型默认false
	 */
	private Boolean available = Boolean.FALSE;

	@Size(min = 0, max = 20)
	private String keyword;

	@Size(max = 255)
	private String description;

}
