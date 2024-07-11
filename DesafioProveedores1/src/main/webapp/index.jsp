<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Proveedores</title>
</head>
<body>
    <h1>Registro de Proveedores</h1>
    <form action="ProveedorServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        <label for="rut">RUT:</label>
        <input type="text" id="rut" name="rut" required><br><br>
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>
        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br><br>
        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" required><br><br>
        <label for="contacto">Contacto:</label>
        <input type="text" id="contacto" name="contacto" required><br><br>
        <label for="telefono_contacto">Teléfono de Contacto:</label>
        <input type="text" id="telefono_contacto" name="telefono_contacto" required><br><br>
        <input type="submit" value="Registrar">
    </form>
    <h2>Lista de Proveedores</h2>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>RUT</th>
            <th>Dirección</th>
            <th>Correo</th>
            <th>Teléfono</th>
            <th>Contacto</th>
            <th>Teléfono de Contacto</th>
        </tr>
        <%
            // Aquí se insertará la lógica para mostrar los proveedores desde la base de datos
            List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
            if (proveedores != null) {
                for (Proveedor proveedor : proveedores) {
        %>
            <tr>
                <td><%= proveedor.getNombre() %></td>
                <td><%= proveedor.getRut() %></td>
                <td><%= proveedor.getDireccion() %></td>
                <td><%= proveedor.getCorreo() %></td>
                <td><%= proveedor.getTelefono() %></td>
                <td><%= proveedor.getContacto() %></td>
                <td><%= proveedor.getTelefonoContacto() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
