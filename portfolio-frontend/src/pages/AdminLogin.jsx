import { useState } from "react";
import { login } from "../services/auth";
import { useNavigate, Navigate } from "react-router-dom";

function AdminLogin() {
  const [correo, setCorreo] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  if (localStorage.getItem("token")) {
      return <Navigate to="/admin" replace />;
  }

  const handleLogin = async () => {
    try {
      await login(correo, password);
      navigate("/admin");
    } catch {
      alert("Error al iniciar sesión");
    }
  };

  return (
    <div className="admin-login">
      <h2>Admin Login</h2>

      <input
        value={correo}
        placeholder="Correo"
        onChange={(e) => setCorreo(e.target.value)}
      />

      <input
        type="password"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={handleLogin}>Ingresar</button>
    </div>
  );
}

export default AdminLogin;