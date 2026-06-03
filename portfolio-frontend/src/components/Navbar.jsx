import { useState, useEffect } from "react";
import logo from "../images/logoNav.png";
import { useTranslation } from "react-i18next";
import i18n from "i18next";

function Navbar() {
  const [active, setActive] = useState("hero");
  const { t,i18n } = useTranslation();
  const isSpanish = i18n.language === "es";

  const toggleLang = () => {
    i18n.changeLanguage(isSpanish ? "en" : "es");
  };

  const handleScroll = () => {
    const sections = ["hero","about", "proyectos", "contacto"];

    sections.forEach((id) => {
      const section = document.getElementById(id);
      const rect = section.getBoundingClientRect();

      if (rect.top <= 150 && rect.bottom >= 150) {
        setActive(id);
      }
    });
  };

  useEffect(() => {
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  const scrollToSection = (id) => {
    document.getElementById(id).scrollIntoView({
      behavior: "smooth"
    });
  };

  return (
    <nav className="navbar">

    <img src={logo} className  ="logoNav"/>

      <ul>
        <li
          className={active === "hero" ? "active" : ""}
          onClick={() => scrollToSection("hero")}
        >
        {t("nav.inicio")}
        </li>
        <li
          className={active === "about" ? "active" : ""}
                  onClick={() => scrollToSection("about")}
                >
                  {t("nav.about")}
                </li>
        <li
          className={active === "proyectos" ? "active" : ""}
          onClick={() => scrollToSection("proyectos")}
        >
       {t("nav.proyectos")}
        </li>

        <li
          className={active === "contacto" ? "active" : ""}
          onClick={() => scrollToSection("contacto")}
        >
        {t("nav.contacto")}
        </li>
        <div className="nav-divider"></div>
        <div className="nav-lang">
              <button
                onClick={toggleLang}
                className={isSpanish ? "btn-lang es" : "btn-lang en"}
              >
                {isSpanish ? "EN" : "ES"}
              </button>
        </div>
      </ul>
    </nav>
  );
}

export default Navbar;