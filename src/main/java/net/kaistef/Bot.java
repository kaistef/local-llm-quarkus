package net.kaistef;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;

/**
 * This is a sample Bot, it is configured to ingest the 'easy-rag-catalog/'.
 * You can @Inject this Bot in your Rest resource
 * <p>
 * \{@code
 *
 * @Inject Bot bot;
 * @POST
 * @Produces(MediaType.TEXT_PLAIN) public String chat(String q) {
 * return bot.chat(q);
 * }
 * }
 */
@SuppressWarnings("unused")
@RegisterAiService // no need to declare a retrieval augmentor here, it is automatically generated and discovered
public interface Bot {

    @SystemMessage("""
            You are an AI named Bob answering questions about financial products.
            Your response must be polite, use the same language as the question, and be relevant to the question.
            When you don't know, respond that you don't know the answer and the bank will contact the customer directly.
            """)
    @McpToolBox("docker")
    String chat(@UserMessage String question);
}