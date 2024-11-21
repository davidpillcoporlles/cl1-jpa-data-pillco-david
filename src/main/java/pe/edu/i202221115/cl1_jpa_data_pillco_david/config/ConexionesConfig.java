package pe.edu.i202221115.cl1_jpa_data_pillco_david.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import javax.sql.DataSource;

public class ConexionesConfig {

        @Value("${DB_WORLD_URL}")
        private String dbWorldUrl;

        @Value("${DB_WORLD_USER}")
        private String dbWorldUser;

        @Value("${DB_WORLD_PASS}")
        private String dbWorldPass;

        @Value("${DB_WORLD_DRIVER}")
        private String dbWorldDriver;

        @Bean
        public HikariDataSource hikariDataSource() {

            HikariConfig config = new HikariConfig();

            // Configurar propiedades de conexión a BD
            config.setJdbcUrl(dbWorldUrl);
            config.setUsername(dbWorldUser);
            config.setPassword(dbWorldPass);
            config.setDriverClassName(dbWorldDriver);

            // Configuración del pool de HikariCP según los requisitos
            config.setMaximumPoolSize(30);        // Máximo 30 conexiones
            config.setMinimumIdle(4);             // Mínimo 4 conexiones inactivas
            config.setIdleTimeout(240000);        // Tiempo de inactividad máximo: 4 minutos (240,000 ms)
            config.setConnectionTimeout(45000);   // Tiempo máximo de espera para obtener una conexión: 45 segundos (45,000 ms)

            System.out.println("###### HikariCP Initialized with custom configuration ######");

            return new HikariDataSource(config);
        }
}