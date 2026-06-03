import { FaGithub, FaLinkedin, FaEnvelope } from "react-icons/fa";

export default function Footer() {
  return (
    <footer className="footer">
      <div className="footer-content">
          <span>
                    © Gabriel Condori - {new Date().getFullYear()}
        </span>
        <div className="footer-social">
          <a href="https://github.com/GabyC3" target="_blank" rel="noreferrer">
            <FaGithub />
          </a>
          <a href="https://linkedin.com/in/gabriel-condori" target="_blank" rel="noreferrer">
            <FaLinkedin />
          </a>
          <a href="mailto:gabyrc69@gmail.com">
            <FaEnvelope />
          </a>
        </div>

      </div>
    </footer>
  );
}