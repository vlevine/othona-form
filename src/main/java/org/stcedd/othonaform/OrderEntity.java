package org.stcedd.othonaform;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends Auditable {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String name;
	private String telephone;
	private String parish;
	private Integer adults;
	private Integer youths;
	private Integer children;
	@Builder.Default
	private double total = 0.;
	@Builder.Default
	private double paid = 0.;
}
