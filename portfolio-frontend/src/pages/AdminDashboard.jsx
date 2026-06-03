import { useEffect, useState } from "react";
import api from "../services/api";
import { logout } from "../services/auth";

function AdminDashboard() {
  const [proyectos, setProyectos] = useState([]);

  const [mostrarForm, setMostrarForm] = useState(false);

  const [nuevoProyecto, setNuevoProyecto] = useState({
    titulo: "",
    descripcion: "",
    enlace: "",
    usuario: ""
  });

  // Visitas
  const [stats, setStats] = useState({total: 0, hoy: 0});

  // GET PROYECTOS
  const cargarProyectos = () => {
    api.get("/proyectos")
      .then(res => setProyectos(res.data))
      .catch(() => {
        alert("No autorizado");
        logout();
        window.location.href = "/login";
      });
  };

  useEffect(() => {
    cargarProyectos();
  }, []);

  // AGREGAR PROYECTO
  const handleAgregar = async () => {
    try {
      await api.post("/proyectos", nuevoProyecto);

      setNuevoProyecto({
        titulo: "",
        descripcion: "",
        enlace: "",
        usuario: ""
      });

      setMostrarForm(false);
      cargarProyectos();
    } catch (err) {
      alert("Error al agregar proyecto");
    }
  };

  // ELIMINAR PROYECTO
  const handleEliminar = async (id) => {
    if (!window.confirm("¿Eliminar proyecto?")) return;

    try {
      await api.delete(`/proyectos/${id}`);
      cargarProyectos();
    } catch (err) {
      alert("Error al eliminar");
    }
  };

    useEffect(() => {
        api.get("/visitas/stats")
        .then(res => setStats(res.data));
    }, []);

  return (
    <div className="admin-panel">
      <h2>Panel Admin</h2>

      <button onClick={() => {
        logout();
        window.location.href = "/login";
      }}>
        Logout
      </button>

      {/* BOTÓN AGREGAR */}
      <button onClick={() => setMostrarForm(!mostrarForm)}>
        {mostrarForm ? "Cancelar" : "Agregar Proyecto"}
      </button>

      {/* FORMULARIO */}
      {mostrarForm && (
        <div className="form-proyecto">
          <input
            placeholder="Título"
            value={nuevoProyecto.titulo}
            onChange={(e) =>
              setNuevoProyecto({ ...nuevoProyecto, titulo: e.target.value })
            }
          />

          <input
            placeholder="Descripción"
            value={nuevoProyecto.descripcion}
            onChange={(e) =>
              setNuevoProyecto({ ...nuevoProyecto, descripcion: e.target.value })
            }
          />

          <input
            placeholder="Enlace"
            value={nuevoProyecto.enlace}
            onChange={(e) =>
              setNuevoProyecto({ ...nuevoProyecto, enlace: e.target.value })
            }
          />

          <input
            placeholder="Usuario"
            value={nuevoProyecto.usuarioId}
            onChange={(e) =>
              setNuevoProyecto({ ...nuevoProyecto, usuarioId: e.target.value })
            }
          />

          <button onClick={handleAgregar}>
            Guardar
          </button>
        </div>
      )}

      {/* LISTA DE PROYECTOS */}
      {proyectos.map(p => (
        <div key={p.id} className="admin-card">
           <img src={p.imagen || "https://picsum.photos/400/250"}
                          alt={p.titulo} />
          <h3>{p.titulo}</h3>
          <p>{p.descripcion}</p>
          <p>{p.enlace}</p>
          <p>{p.usuarioId}</p>

          {/* BOTÓN ELIMINAR */}
          <button onClick={() => handleEliminar(p.id)}>
            Eliminar
          </button>
        </div>
      ))}
        <div className="stats">
          <h3>Visitas Totales: {stats.total}</h3>
          <h3>Visitas Hoy: {stats.hoy}</h3>
        </div>
    </div>
  );
}

export default AdminDashboard;