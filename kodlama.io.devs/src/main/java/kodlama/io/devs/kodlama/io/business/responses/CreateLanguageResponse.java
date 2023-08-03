package kodlama.io.devs.kodlama.io.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLanguageResponse {
	private int id;
	private String name;
}
