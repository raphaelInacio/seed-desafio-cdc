package br.com.casadocodigo.seed.autor;

import br.com.casadocodigo.seed.DataBuilder;
import br.com.casadocodigo.seed.SeedDesafioCdcApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class AutorControllerTest extends SeedDesafioCdcApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private AutorController autorController;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(autorController).build();

    }

    @Test
    void deveCadastrarAutorQuandoDadosCorretosForemEnviados() throws Exception {
        var autor = DataBuilder.autor();
        autor.setEmail("novo.email" + autor.getEmail());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    void deveResponderCom400QuandoNomeForNulo() throws Exception {
        var autor = DataBuilder.autor();
        autor.setNome(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    @Test
    void deveResponderCom400QuandoEmailForNulo() throws Exception {
        var autor = DataBuilder.autor();
        autor.setEmail(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError()).andDo(print());
    }

    @Test
    void deveResponderCom400QuandoEmailForInvalido() throws Exception {
        var autor = DataBuilder.autor();
        autor.setEmail("email-invalido");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void deveResponderCom400QuandoDescricaoForNulo() throws Exception {
        var autor = DataBuilder.autor();
        autor.setDescricao(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void deveResponderCom400QuandoDescricaoForMaiorQue400() throws Exception {
        var autor = DataBuilder.autor();
        autor.setDescricao("ddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasddddddddddddddddddddddddddddddddddddddddddddddddddasdddddddddddddddddddddddddddddddddddddddddddddddddd");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError()).andDo(print());
    }

    @Test
    void naoDevePermitirCadastrarEmailDuplicado() throws Exception {

        var autor = DataBuilder.autor();
        autor.setEmail("novo.email.1" + autor.getEmail());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(print());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/autores")
                .content(mapper.writeValueAsString(autor))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError()).andDo(print());
    }

}