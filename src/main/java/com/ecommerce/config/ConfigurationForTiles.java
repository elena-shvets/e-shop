package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Class {@link com.ecommerce.config.ConfigurationForTiles}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 20.10.15
 */
@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {ConfigurationForTiles.BASE_PACKAGE,"com.ecommerce"})
public class ConfigurationForTiles {
//    static final String BASE_PACKAGE = "com.ecommerce";


    /**
         * Initialise Tiles on application startup and identify the location of the tiles configuration file, tiles.xml.
         *
         * @return tiles configurer
         */
        @Bean
        public TilesConfigurer tilesConfigurer() {
            final TilesConfigurer configurer = new TilesConfigurer();
            configurer.setDefinitions(new String[] {"classpath:WEB-INF/views/tiles.xml"});
            configurer.setCheckRefresh(true);
            return configurer;
        }

        /**
         * Introduce a Tiles view resolver, this is a convenience implementation that extends URLBasedViewResolver.
         *
         * @return tiles view resolver
         */
        @Bean
        public TilesViewResolver tilesViewResolver() {
            final TilesViewResolver resolver = new TilesViewResolver();
            resolver.setViewClass(TilesView.class);
            return resolver;
        }

}