/**
 * Language.java
 */
package kodlama.io.Devs.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mustafa Furkan BİLEN
 * @since Oct 31, 2022 8:59:05 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "language",fetch = FetchType.LAZY
									,cascade = CascadeType.ALL)
	private Set<LanguageTechnology> languageTechnologies;
	
}
