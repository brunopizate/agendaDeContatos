
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static class SpringApplication {

        private static void run(Class<Application> aClass, String[] args) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @SuppressWarnings("unused")
        public SpringApplication() {
        }
    }
}

