package cn.chenzw.springboot.batch.basic.samples.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;

@StepScope
public class MyChunkListener implements ChunkListener {

    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之前");
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        System.out.println("chunk执行之后");
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        System.out.println("chunk执行报错之后:");
    }
}
