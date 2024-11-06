package com.fier.products.modules.customers.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;

import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fier.products.modules.customers.repositories.ProductRepository;
import com.fier.products.modules.models.entity.products.Feedback;


@ExtendWith(MockitoExtension.class)
class ProductsServiceTest {

    @InjectMocks
    private ProductsService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Feedback feedback;

    @Captor
    private ArgumentCaptor<Feedback> feedbackCaptor;

    @Captor
    private ArgumentCaptor<String> productIdCaptor;

    @Test
    @DisplayName("Valida o objeto completo do feedback que o usuário cadastrou")
    void testCreateFeedbacksSuccess() {
        BDDMockito
            .given(productRepository.createFeedback("1", feedback))
            .willReturn(true);

        boolean hasInserted = this.productService.createFeedbacks("1", feedback);

        Assertions.assertEquals(true, hasInserted);
    }

    @Test
    @DisplayName("Caso de teste para quando o cadastro de feedback retornar um erro")
    void testCreateFeedbacksError() {
        BDDMockito
            .given(productRepository.createFeedback("1", feedback))
            .willReturn(false);

        Assertions.assertThrows(Error.class, () -> this.productService.createFeedbacks("1", feedback));
    }

    @Test
    @DisplayName("Cenário para validar o objeto recebido em feedback")
    void testSaveFeedback() {
        //arrange
        Feedback feedbackForSave = this.buildFeedback(4, "Fausto", "Excelente Produto");
        BDDMockito
            .given(this.productRepository.createFeedback("1", feedbackForSave))
            .willReturn(true);

        //act
        this.productService.createFeedbacks("1", feedbackForSave);

        //assert
        BDDMockito
            .then(this.productRepository)
            .should()
            .createFeedback(productIdCaptor.capture(), feedbackCaptor.capture());

        Feedback feedbackSaved = feedbackCaptor.getValue();
        Assertions.assertEquals(feedbackForSave, feedbackSaved);
    }

    @Test
    void testFetchProductById() {
        // trazer o produto pelo id

    }

    @Test
    void testFetchProducts() {

    }

    @Test
    void testFetchProductsByCategory() {

    }

    private Feedback buildFeedback(int avaliationLevel, String username, String comment) {
        return Feedback.of(avaliationLevel, username, comment);
    }
}
