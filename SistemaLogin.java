public class SistemaLogin {

    private Map<String, Usuario> usuarios;

    public SistemaLogin() {
        usuarios = new HashMap<>();

        // Agregar usuarios de prueba
        usuarios.put("controlador", new Usuario("controlador", "contrasena", Rol.CONTROLADOR));
        usuarios.put("piloto", new Usuario("piloto", "contrasena", Rol.PILOTO));
    }

    public boolean login(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarios.get(nombreUsuario);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return true;
        }

        return false;
    }

    public Rol getRol(String nombreUsuario) {
        Usuario usuario = usuarios.get(nombreUsuario);

        if (usuario != null) {
            return usuario.getRol();
        }

        return null;
    }

    public static void main(String[] args) {
        SistemaLogin sistemaLogin = new SistemaLogin();

        // Simular un inicio de sesión
        String nombreUsuario = "controlador";
        String contrasena = "contrasena";

        if (sistemaLogin.login(nombreUsuario, contrasena)) {
            Rol rol = sistemaLogin.getRol(nombreUsuario);

            if (rol == Rol.CONTROLADOR) {
                // Redirigir al usuario a la interfaz de controladores
            } else if (rol == Rol.PILOTO) {
                // Redirigir al usuario a la interfaz de pilotos
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }

    private enum Rol {
        CONTROLADOR,
        PILOTO
    }

    private class Usuario {

        private String nombreUsuario;
        private String contrasena;
        private Rol rol;

        public Usuario(String nombreUsuario, String contrasena, Rol rol) {
            this.nombreUsuario = nombreUsuario;
            this.contrasena = contrasena;
            this.rol = rol;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public Rol getRol() {
            return rol;
        }
    }
}
