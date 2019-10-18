package com.vladsch.flexmark.test.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.test.spec.SpecExample;
import com.vladsch.flexmark.util.ast.KeepType;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboIssuesSpecTest extends ComboSpecTestCase {
    private static final String SPEC_RESOURCE = "/issues_ast_spec.md";
    private static final DataHolder OPTIONS = new MutableDataSet()
            .set(HtmlRenderer.INDENT_SIZE, 2)
            .set(HtmlRenderer.PERCENT_ENCODE_URLS, true);

    protected static final Map<String, DataHolder> optionsMap = new HashMap<>();
    static {
        optionsMap.put("keep-last", new MutableDataSet().set(Parser.REFERENCES_KEEP, KeepType.LAST));
        optionsMap.put("keep-blank-lines", new MutableDataSet().set(Parser.BLANK_LINES_IN_AST, true));
        optionsMap.put("jekyll-macros-in-urls", new MutableDataSet().set(Parser.PARSE_JEKYLL_MACROS_IN_URLS, true));
        optionsMap.put("hdr-no-atx-space", new MutableDataSet().set(Parser.HEADING_NO_ATX_SPACE, true));
        optionsMap.put("hdr-no-lead-space", new MutableDataSet().set(Parser.HEADING_NO_LEAD_SPACE, true));
        optionsMap.put("list-no-break", new MutableDataSet().set(Parser.LISTS_END_ON_DOUBLE_BLANK, false));
        optionsMap.put("list-break", new MutableDataSet().set(Parser.LISTS_END_ON_DOUBLE_BLANK, true));
        optionsMap.put("list-no-loose", new MutableDataSet().set(Parser.LISTS_AUTO_LOOSE, false));
        optionsMap.put("list-loose-if-prev", new MutableDataSet().set(Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE, true));
        optionsMap.put("list-no-start", new MutableDataSet().set(Parser.LISTS_ORDERED_LIST_MANUAL_START, false));
        optionsMap.put("list-no-bullet-match", new MutableDataSet().set(Parser.LISTS_DELIMITER_MISMATCH_TO_NEW_LIST, false));
        optionsMap.put("list-no-type-match", new MutableDataSet().set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST, false));
        optionsMap.put("bullet-no-para-break", new MutableDataSet().set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH, false));
        optionsMap.put("bullet-no-item-break", new MutableDataSet().set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, false));
        optionsMap.put("empty-bullet-item-break", new MutableDataSet().set(Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, true));
        optionsMap.put("empty-bullet-no-sub-item-break", new MutableDataSet().set(Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, false));
        optionsMap.put("empty-bullet-sub-item-break", new MutableDataSet().set(Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, true));
        optionsMap.put("ordered-no-para-break", new MutableDataSet().set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH, false));
        optionsMap.put("ordered-non-1-para-break", new MutableDataSet().set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, true));
        optionsMap.put("ordered-no-non-1-para-break", new MutableDataSet().set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, false));
        optionsMap.put("ordered-no-item-break", new MutableDataSet().set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH, false));
        optionsMap.put("ordered-non-1-item-break", new MutableDataSet().set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, true));
        optionsMap.put("ordered-no-non-1-item-break", new MutableDataSet().set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, false));
        optionsMap.put("list-item-mismatch-to-subitem", new MutableDataSet().set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST, true));
        optionsMap.put("thematic-break-no-relaxed-start", new MutableDataSet().set(Parser.THEMATIC_BREAK_RELAXED_START, false));
        optionsMap.put("test-completions", new MutableDataSet().set(Parser.THEMATIC_BREAK_RELAXED_START, false).set(HtmlRenderer.SUPPRESS_INLINE_HTML, true));
        optionsMap.put("escape-html", new MutableDataSet().set(HtmlRenderer.ESCAPE_HTML, true));
        optionsMap.put("escape-html-blocks", new MutableDataSet().set(HtmlRenderer.ESCAPE_HTML_BLOCKS, true));
        optionsMap.put("escape-html-comment-blocks", new MutableDataSet().set(HtmlRenderer.ESCAPE_HTML_COMMENT_BLOCKS, true));
        optionsMap.put("escape-inline-html", new MutableDataSet().set(HtmlRenderer.ESCAPE_INLINE_HTML, true));
        optionsMap.put("escape-inline-html-comments", new MutableDataSet().set(HtmlRenderer.ESCAPE_INLINE_HTML_COMMENTS, true));
        optionsMap.put("suppress-html", new MutableDataSet().set(HtmlRenderer.SUPPRESS_HTML, true));
        optionsMap.put("suppress-html-blocks", new MutableDataSet().set(HtmlRenderer.SUPPRESS_HTML_BLOCKS, true));
        optionsMap.put("suppress-html-comment-blocks", new MutableDataSet().set(HtmlRenderer.SUPPRESS_HTML_COMMENT_BLOCKS, true));
        optionsMap.put("suppress-inline-html", new MutableDataSet().set(HtmlRenderer.SUPPRESS_INLINE_HTML, true));
        optionsMap.put("suppress-inline-html-comments", new MutableDataSet().set(HtmlRenderer.SUPPRESS_INLINE_HTML_COMMENTS, true));
        optionsMap.put("no-class-prefix", new MutableDataSet().set(HtmlRenderer.FENCED_CODE_LANGUAGE_CLASS_PREFIX, ""));
        optionsMap.put("parse-inner-comments", new MutableDataSet().set(Parser.PARSE_INNER_HTML_COMMENTS, true));
        optionsMap.put("multi-line-image-url", new MutableDataSet().set(Parser.PARSE_MULTI_LINE_IMAGE_URLS, true));
        optionsMap.put("unmatched-fence", new MutableDataSet().set(Parser.MATCH_CLOSING_FENCE_CHARACTERS, false));
        optionsMap.put("dummy-identifier", new MutableDataSet().set(Parser.INTELLIJ_DUMMY_IDENTIFIER, true));
        optionsMap.put("code-no-trim-trailing", new MutableDataSet().set(Parser.INDENTED_CODE_NO_TRAILING_BLANK_LINES, false));
        optionsMap.put("ordered-dot-only", new MutableDataSet().set(Parser.LISTS_ORDERED_ITEM_DOT_ONLY, true));
        optionsMap.put("block-quote-extend", new MutableDataSet().set(Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE, true));
        optionsMap.put("block-ignore-blank", new MutableDataSet().set(Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE, true));
        optionsMap.put("block-no-interrupt-paragraph", new MutableDataSet().set(Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH, false));
        optionsMap.put("setext-marker-length", new MutableDataSet().set(Parser.HEADING_SETEXT_MARKER_LENGTH, 3));
        optionsMap.put("src-pos", new MutableDataSet().set(HtmlRenderer.SOURCE_POSITION_ATTRIBUTE, "md-pos"));
        optionsMap.put("src-pos-lines", new MutableDataSet().set(HtmlRenderer.SOURCE_POSITION_PARAGRAPH_LINES, true));
        optionsMap.put("src-wrap-html", new MutableDataSet().set(HtmlRenderer.SOURCE_WRAP_HTML, true));
        optionsMap.put("src-wrap-blocks", new MutableDataSet().set(HtmlRenderer.SOURCE_WRAP_HTML_BLOCKS, true));
        optionsMap.put("hard-line-break-limit", new MutableDataSet().set(Parser.HARD_LINE_BREAK_LIMIT, true));
        optionsMap.put("fixed-indent", new MutableDataSet().setFrom(ParserEmulationProfile.FIXED_INDENT));
        optionsMap.put("html-comment-full-lines", new MutableDataSet().set(Parser.HTML_BLOCK_COMMENT_ONLY_FULL_LINE, true));
        optionsMap.put("allow-javascript", new MutableDataSet().set(HtmlRenderer.SUPPRESSED_LINKS, ""));
        optionsMap.put("pass-through", new MutableDataSet().set(HtmlRenderer.FORMAT_FLAGS, HtmlRenderer.PASS_THROUGH));
        optionsMap.put("strip-indent", new MutableDataSet().set(TestUtils.SOURCE_INDENT, "> > "));
        optionsMap.put("no-html-blocks", new MutableDataSet().set(Parser.HTML_BLOCK_PARSER, false));
        optionsMap.put("url-spaces", new MutableDataSet().set(Parser.SPACE_IN_LINK_URLS, true));
        optionsMap.put("sub-parse", new MutableDataSet()
                .set(TestUtils.SOURCE_PREFIX, "" +
                        "Source Prefix\n" +
                        "")
                .set(TestUtils.SOURCE_SUFFIX, "" +
                        "Source Suffix\n" +
                        "")
        );

        final List<String> customHtmlBlockTags = new ArrayList<>(Parser.HTML_BLOCK_TAGS.getFrom(null));
        customHtmlBlockTags.add("warp10-warpscript-widget");
        optionsMap.put("custom-html-block", new MutableDataSet()
                .set(Parser.HTML_BLOCK_TAGS, customHtmlBlockTags)
                .set(Parser.HTML_BLOCK_DEEP_PARSER, true)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, false)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, true)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, false)
        );
        optionsMap.put("deep-html-parser", new MutableDataSet()
                .set(Parser.HTML_BLOCK_DEEP_PARSER, true)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS, false)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE, true)
                .set(Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG, false)
        );
    }
    public ComboIssuesSpecTest(SpecExample example) {
        super(example);
    }

    @Parameterized.Parameters(name = "{0}")
    public static List<Object[]> data() {
        return getTestData(SPEC_RESOURCE);
    }

    @Nullable
    @Override
    public DataHolder options(String option) {
        return optionsMap.get(option);
    }

    @NotNull
    @Override
    public String getSpecResourceName() {
        return SPEC_RESOURCE;
    }

    @NotNull
    public Parser parser(@Nullable DataHolder OPTIONS) {
        return Parser.builder(OPTIONS).build();
    }

    @NotNull
    public HtmlRenderer renderer(@Nullable DataHolder OPTIONS) {
        return HtmlRenderer.builder(OPTIONS).build();
    }

    @Override
    public @NotNull SpecExampleRenderer getSpecExampleRenderer(@NotNull SpecExample example, @Nullable DataHolder exampleOptions) {
        DataHolder combinedOptions = combineOptions(OPTIONS, exampleOptions);
        return new FlexmarkSpecExampleRenderer(example, combinedOptions, Parser.builder(combinedOptions).build(), HtmlRenderer.builder(combinedOptions).build(), true);
    }
}