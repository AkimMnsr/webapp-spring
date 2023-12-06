package project.filmotheque.Config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import project.filmotheque.BO.Genre;
import project.filmotheque.BO.Participant;
import project.filmotheque.Services.FilmService;

@Configuration
public class Config {

    @Bean
    @ApplicationScope
    public List<Genre> genres(FilmService service) {
        return service.getListGenre();
    }

    @Bean
    @ApplicationScope
    public List<Participant> participants(FilmService service) {
        return service.getParticipants();
    }

}
