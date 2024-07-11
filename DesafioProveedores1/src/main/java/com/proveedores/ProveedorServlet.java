package com.proveedores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");
        
        if(nombre.isEmpty() || rut.isEmpty() || direccion.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contacto.isEmpty() || telefonoContacto.isEmpty()) {
            response.sendRedirect("error.jsp");
        } else {
            try {
                Connection conn = DatabaseConnection.getConnection();
                String query = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nombre);
                ps.setString(2, rut);
                ps.setString(3, direccion);
                ps.setString(4, correo);
                ps.setString(5, telefono);
                ps.setString(6, contacto);
                ps.setString(7, telefonoContacto);
                ps.executeUpdate();
                
                List<Proveedor> proveedores = new ArrayList<>();
                query = "SELECT * FROM proveedores ORDER BY nombre ASC";
                ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Proveedor proveedor = new Proveedor(rs.getInt("id"), rs.getString("nombre"), rs.getString("rut"), rs.getString("direccion"), rs.getString("correo"), rs.getString("telefono"), rs.getString("contacto"), rs.getString("telefono_contacto"));
                    proveedores.add(proveedor);
                }
                request.setAttribute("proveedores", proveedores);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch(Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }
    }
}
