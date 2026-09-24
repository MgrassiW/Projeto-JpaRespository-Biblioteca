package Projeto.Biblioteca.Service;


import Projeto.Biblioteca.DTO.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginRequest request) { // aqui ele recebe a requisição com email e senha

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.senha()
                )// cria um objeto com as ceredenciais que serão autenticadas
        );

        return jwtService.gerarToken(request.email()); // ele vai retornar o token referente ao email do request
    }
}
