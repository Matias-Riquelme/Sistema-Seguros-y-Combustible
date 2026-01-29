package tadGestionUsuario.controller;

import tadGestionUsuario.DTO.UserDTO;
import tadGestionUsuario.service.IKeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('admin_client_role')")
public class KeycloakController {

    @Autowired
    private IKeycloakService keycloakService;

    // Listar todos los usuarios

    @PreAuthorize("hasRole('admin_client_role')")
    @GetMapping("/search")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }
    // Listar todos los usuarios con roles

    @PreAuthorize("hasRole('admin_client_role')")
    @GetMapping("/search-roles")
    public ResponseEntity<?> findAllUsersWithRoles() {
        return ResponseEntity.ok(keycloakService.findAllUsersWithRoles());
    }

    // Buscar un usuario por username
    @PreAuthorize("hasRole('admin_client_role')")
    @GetMapping("/search/{username}")
    public ResponseEntity<?> searchUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    // Crear un usuario
    @PreAuthorize("hasRole('admin_client_role')")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        String response = keycloakService.createUser(userDTO);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
    }

    // Actualizar un usuario
    @PreAuthorize("hasRole('admin_client_role')")
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        keycloakService.updateUser(userId, userDTO);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    // Eliminar un usuario
    @PreAuthorize("hasRole('admin_client_role')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        keycloakService.deleteUser(userId);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
}
