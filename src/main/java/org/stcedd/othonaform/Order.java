package org.stcedd.othonaform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {
	private Long id;
	private String email;
	private String name;
	private String telephone;
	private String parish;
	private Integer adults;
	private Integer youths;
	private Integer children;
	private double total;
	private double paid;
}
