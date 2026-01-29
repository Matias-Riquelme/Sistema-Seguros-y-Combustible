package tadGestionUsuario.controller;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tadGestionUsuario.service.IKeycloakRoleService;

import java.util.List;

@RestController
@RequestMapping("/keycloak/roles")
@RequiredArgsConstructor
@PreAuthorize("hasRole('admin_client_role')")
public class KeycloakRoleController {

    private final IKeycloakRoleService roleService;

    // Crear un rol
    // @PreAuthorize("hasRole('admin_client_role')")
    // @PostMapping("/create")
    // public ResponseEntity<String> createRole(@RequestParam String roleName) {
    // roleService.createRole(roleName);
    // return ResponseEntity.ok("Rol creado exitosamente");
    // }

    // Listar todos los roles
    @PreAuthorize("hasRole('admin_client_role')")
    @GetMapping("/list")
    public ResponseEntity<List<RoleRepresentation>> findAllRoles() {
        return ResponseEntity.ok(roleService.findAllRoles());
    }

    // Asignar un rol a un usuario
    @PreAuthorize("hasRole('admin_client_role')")
    @PostMapping("/assign/{username}/{roleName}")
    public ResponseEntity<String> assignRole(@PathVariable String username, @PathVariable String roleName) {
        roleService.assignRoleToUser(username, roleName);
        return ResponseEntity.ok("Rol asignado exitosamente");
    }

    // Eliminar un rol de un usuario si tienes uno o mas roles
    @PreAuthorize("hasRole('admin_client_role')")
    @DeleteMapping("/remove/{username}/{roleName}")
    public ResponseEntity<String> removeRole(@PathVariable String username, @PathVariable String roleName) {
        roleService.removeRoleFromUser(username, roleName);
        return ResponseEntity.ok("Rol eliminado exitosamente");
    }

}
